#!/usr/bin/env node
import { readdirSync, readFileSync } from 'node:fs';
import { join } from 'node:path';
import { spawnSync } from 'node:child_process';

const checks = [
  ['AC-001', 'rootReadmeListsAllPatterns', 'README raiz apresenta os padroes disponiveis'],
  ['AC-002', 'rootReadmeLinksPointToFoldersWithReadme', 'README raiz redireciona para cada pasta'],
  ['AC-003', 'patternReadmesContainRequiredSections', 'cada pasta tem README explicativo'],
  ['AC-004', 'patternReadmesLinkBackAndReferenceRelatedPatterns', 'README de padrao conecta catalogo'],
  ['AC-005', 'eachPatternContainsJavaSource', 'cada padrao possui codigo Java'],
  ['AC-006', 'publicJavaApiHasJavadoc', 'codigo publico possui JavaDoc'],
  ['AC-007', 'examplesUseOnlyJavaForImplementation', 'repositorio usa Java nos exemplos'],
  ['AC-008', 'mavenBuildCompilesAndRunsExamples', 'build valida exemplos Java'],
  ['AC-009', 'validationProtectsCatalogStructure', 'verificacao protege estrutura'],
  ['AC-010', 'rootReadmeListsExpansionPatterns', 'README raiz lista novos padroes'],
  ['AC-011', 'newPatternsHaveReadmeJavaAndSpringComponent', 'novos padroes tem README e Spring'],
  ['AC-012', 'existingPatternsExposeSpringComponents', 'padroes existentes tem componentes Spring'],
  ['AC-013', 'allPatternsHaveBehaviorTests', 'todos os padroes tem testes comportamentais'],
  ['AC-014', 'tapVerificationScriptDeclaresExpansionChecks', 'verificacao ONP emite TAP da expansao'],
];

const maven = spawnSync('./mvnw', ['-q', 'test'], {
  cwd: process.cwd(),
  encoding: 'utf8',
});

const reportDir = join(
  process.cwd(),
  'catalog-validation',
  'target',
  'surefire-reports'
);
const reportXml = readSurefireXml(reportDir);

console.log('TAP version 13');
console.log(`1..${checks.length}`);

let failed = false;
checks.forEach(([acId, methodName, title], index) => {
  const result = resultFor(reportXml, methodName);
  if (result.pass && maven.status === 0) {
    console.log(`ok ${index + 1} - @spec:${acId} ${title}`);
    return;
  }

  failed = true;
  console.log(`not ok ${index + 1} - @spec:${acId} ${title}`);
  const diagnostic = result.reason || summarizeFailure(maven);
  if (diagnostic) {
    console.log(`  ---`);
    console.log(`  message: ${JSON.stringify(diagnostic)}`);
    console.log(`  ...`);
  }
});

process.exit(failed || maven.status !== 0 ? 1 : 0);

function readSurefireXml(directory) {
  try {
    return readdirSync(directory)
      .filter((file) => file.startsWith('TEST-') && file.endsWith('.xml'))
      .map((file) => readFileSync(join(directory, file), 'utf8'))
      .join('\n');
  } catch {
    return '';
  }
}

function resultFor(reportXml, methodName) {
  const escapedMethod = methodName.replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
  const pattern = new RegExp(
    `<testcase\\b[^>]*name="${escapedMethod}"[^>]*(?:/>|>[\\s\\S]*?</testcase>)`
  );
  const match = reportXml.match(pattern);

  if (!match) {
    return { pass: false, reason: `JUnit method ${methodName} was not reported by Surefire` };
  }
  if (/<failure\b/.test(match[0])) {
    return { pass: false, reason: `JUnit method ${methodName} failed` };
  }
  if (/<error\b/.test(match[0])) {
    return { pass: false, reason: `JUnit method ${methodName} errored` };
  }
  if (/<skipped\b/.test(match[0])) {
    return { pass: false, reason: `JUnit method ${methodName} was skipped` };
  }
  return { pass: true };
}

function summarizeFailure(result) {
  const output = `${result.stdout || ''}\n${result.stderr || ''}`.trim();
  if (!output) {
    return 'Maven failed without output';
  }
  return output.split(/\r?\n/).slice(-20).join('\n');
}

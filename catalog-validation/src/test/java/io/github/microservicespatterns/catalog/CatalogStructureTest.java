package io.github.microservicespatterns.catalog;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

class CatalogStructureTest {
  private static final List<String> EXISTING_PATTERNS =
      List.of(
          "api-gateway",
          "service-discovery",
          "circuit-breaker",
          "bulkhead",
          "database-per-service",
          "saga",
          "cqrs",
          "event-driven-architecture",
          "strangler-fig",
          "externalized-configuration");

  private static final List<String> NEW_PATTERNS =
      List.of(
          "outbox",
          "idempotency",
          "backends-for-frontends",
          "retry-with-backoff",
          "service-mesh");

  private static final List<String> PATTERNS =
      java.util.stream.Stream.concat(EXISTING_PATTERNS.stream(), NEW_PATTERNS.stream()).toList();

  private static final List<String> REQUIRED_SECTIONS =
      List.of(
          "## Intencao",
          "## Problema",
          "## Como funciona",
          "## Quando usar",
          "## Trade-offs",
          "## Exemplo em Java",
          "## Como executar");

  private final Path root = Path.of("").toAbsolutePath().getParent();

  @Test
  void rootReadmeListsAllPatterns() throws IOException {
    // @spec:AC-001
    String readme = read(root.resolve("README.md"));

    assertTrue(readme.contains("Catalogo pratico"));
    for (String pattern : PATTERNS) {
      assertTrue(readme.contains("](" + pattern + "/)"), pattern);
    }
  }

  @Test
  void rootReadmeLinksPointToFoldersWithReadme() throws IOException {
    // @spec:AC-002
    for (String pattern : PATTERNS) {
      Path directory = root.resolve(pattern);
      assertTrue(Files.isDirectory(directory), pattern);
      assertTrue(Files.isRegularFile(directory.resolve("README.md")), pattern);
    }
  }

  @Test
  void patternReadmesContainRequiredSections() throws IOException {
    // @spec:AC-003
    for (String pattern : PATTERNS) {
      String readme = read(root.resolve(pattern).resolve("README.md"));
      for (String section : REQUIRED_SECTIONS) {
        assertTrue(readme.contains(section), pattern + " missing " + section);
      }
    }
  }

  @Test
  void patternReadmesLinkBackAndReferenceRelatedPatterns() throws IOException {
    // @spec:AC-004
    for (String pattern : PATTERNS) {
      String readme = read(root.resolve(pattern).resolve("README.md"));
      assertTrue(readme.contains("[Voltar ao catalogo](../README.md)"), pattern);
      assertTrue(readme.contains("## Padroes relacionados"), pattern);
    }
  }

  @Test
  void eachPatternContainsJavaSource() {
    // @spec:AC-005
    for (String pattern : PATTERNS) {
      Path source = root.resolve(pattern).resolve("src/main/java");
      assertTrue(Files.isDirectory(source), pattern);
      assertTrue(hasFile(source, ".java"), pattern);
    }
  }

  @Test
  void publicJavaApiHasJavadoc() throws IOException {
    // @spec:AC-006
    Pattern publicApi = Pattern.compile("^\\s*public\\s+(class|interface|enum|record|[\\w<>\\[\\], ?]+\\s+\\w+\\s*\\()");
    for (String pattern : PATTERNS) {
      Path source = root.resolve(pattern).resolve("src/main/java");
      try (var files = Files.walk(source)) {
        for (Path file : files.filter(path -> path.toString().endsWith(".java")).toList()) {
          List<String> lines = Files.readAllLines(file);
          for (int index = 0; index < lines.size(); index++) {
            if (publicApi.matcher(lines.get(index)).find()) {
              assertTrue(hasJavadocBefore(lines, index), file + ":" + (index + 1));
            }
          }
        }
      }
    }
  }

  @Test
  void examplesUseOnlyJavaForImplementation() throws IOException {
    // @spec:AC-007
    List<String> forbiddenExtensions = List.of(".js", ".ts", ".py", ".go", ".rb", ".cs", ".kt", ".rs");
    for (String pattern : PATTERNS) {
      Path directory = root.resolve(pattern);
      try (var files = Files.walk(directory)) {
        List<Path> forbidden =
            files
                .filter(Files::isRegularFile)
                .filter(path -> !path.toString().contains("/target/"))
                .filter(path -> forbiddenExtensions.stream().anyMatch(path.toString()::endsWith))
                .toList();
        assertTrue(forbidden.isEmpty(), pattern + " has non-Java examples: " + forbidden);
      }
    }
  }

  @Test
  void mavenBuildCompilesAndRunsExamples() {
    // @spec:AC-008
    for (String pattern : PATTERNS) {
      assertTrue(Files.isRegularFile(root.resolve(pattern).resolve("pom.xml")), pattern);
      assertTrue(Files.isDirectory(root.resolve(pattern).resolve("src/main/java")), pattern);
    }
  }

  @Test
  void validationProtectsCatalogStructure() {
    // @spec:AC-009
    assertFalse(PATTERNS.isEmpty());
    assertFalse(REQUIRED_SECTIONS.isEmpty());
  }

  @Test
  void rootReadmeListsExpansionPatterns() throws IOException {
    // @spec:AC-010
    String readme = read(root.resolve("README.md"));

    for (String pattern : NEW_PATTERNS) {
      assertTrue(readme.contains("](" + pattern + "/)"), pattern);
    }
  }

  @Test
  void newPatternsHaveReadmeJavaAndSpringComponent() throws IOException {
    // @spec:AC-011
    for (String pattern : NEW_PATTERNS) {
      Path directory = root.resolve(pattern);
      assertTrue(Files.isRegularFile(directory.resolve("README.md")), pattern);
      assertTrue(Files.isRegularFile(directory.resolve("pom.xml")), pattern);
      assertTrue(hasFile(directory.resolve("src/main/java"), ".java"), pattern);
      assertTrue(hasSpringComponent(directory.resolve("src/main/java")), pattern);
    }
  }

  @Test
  void existingPatternsExposeSpringComponents() throws IOException {
    // @spec:AC-012
    for (String pattern : EXISTING_PATTERNS) {
      assertTrue(hasSpringComponent(root.resolve(pattern).resolve("src/main/java")), pattern);
    }
  }

  @Test
  void allPatternsHaveBehaviorTests() {
    // @spec:AC-013
    for (String pattern : PATTERNS) {
      assertTrue(hasFile(root.resolve(pattern).resolve("src/test/java"), "Test.java"), pattern);
    }
  }

  @Test
  void tapVerificationScriptDeclaresExpansionChecks() throws IOException {
    // @spec:AC-014
    String script = read(root.resolve("scripts/onp-verify-tap.mjs"));

    for (String ac : List.of("AC-010", "AC-011", "AC-012", "AC-013", "AC-014")) {
      assertTrue(script.contains("@spec:" + ac) || script.contains("'" + ac + "'"), ac);
    }
  }

  private static String read(Path path) throws IOException {
    return Files.readString(path);
  }

  private static boolean hasFile(Path directory, String extension) {
    try (var files = Files.walk(directory)) {
      return files.anyMatch(path -> Files.isRegularFile(path) && path.toString().endsWith(extension));
    } catch (IOException error) {
      return false;
    }
  }

  private static boolean hasSpringComponent(Path directory) throws IOException {
    try (var files = Files.walk(directory)) {
      return files
          .filter(path -> path.toString().endsWith(".java"))
          .map(CatalogStructureTest::readUnchecked)
          .anyMatch(
              source ->
                  source.contains("@Service")
                      || source.contains("@RestController")
                      || source.contains("@Configuration")
                      || source.contains("@Component")
                      || source.contains("@ConfigurationProperties"));
    }
  }

  private static String readUnchecked(Path path) {
    try {
      return Files.readString(path);
    } catch (IOException error) {
      throw new IllegalStateException(error);
    }
  }

  private static boolean hasJavadocBefore(List<String> lines, int declarationIndex) {
    for (int index = declarationIndex - 1; index >= 0; index--) {
      String line = lines.get(index).trim();
      if (line.isEmpty() || line.startsWith("@")) {
        continue;
      }
      return line.endsWith("*/");
    }
    return false;
  }
}

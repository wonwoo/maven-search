package ml.wonwoo.mavensearch.web;

import ml.wonwoo.mavensearch.search.MavenRepository;
import ml.wonwoo.mavensearch.search.model.Maven;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MavenController {

  private final MavenRepository mavenRepository;

  public MavenController(MavenRepository mavenRepository) {
    this.mavenRepository = mavenRepository;
  }

  @GetMapping("/search")
  public Mono<Maven> search(String q, int row, int start) {
    return this.mavenRepository.select(q, row, start);
  }
}

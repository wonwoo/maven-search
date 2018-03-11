package ml.wonwoo.mavensearch.web;

import ml.wonwoo.mavensearch.search.MavenRepository;
import ml.wonwoo.mavensearch.search.model.Maven;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
public class MavenController {

  private final MavenRepository mavenRepository;

  public MavenController(MavenRepository mavenRepository) {
    this.mavenRepository = mavenRepository;
  }

  @GetMapping("/")
  public Rendering search(@RequestParam(value = "q", defaultValue = "") String q,
                          @RequestParam(value = "row", defaultValue = "20") int row,
                          @RequestParam(value = "start", defaultValue = "0") int start) {
    return Rendering
        .view("home")
        .modelAttribute("maven", this.mavenRepository.select(q, row, start))
        .build();
  }

  @GetMapping("/versions")
  public Rendering versions(@RequestParam(value = "g") String g,
                            @RequestParam(value = "a") String a,
                            @RequestParam(value = "row", defaultValue = "20") int row,
                            @RequestParam(value = "start", defaultValue = "0") int start) {
    return Rendering
        .view("version")
        .modelAttribute("versions",
            this.mavenRepository.versions(g, a, row, start))
        .build();
  }
}

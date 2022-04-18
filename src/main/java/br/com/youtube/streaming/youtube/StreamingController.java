package br.com.youtube.streaming.youtube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class StreamingController {

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping(value = "video/load/{title}", produces = "video/mp4")
    public Mono<Resource> getVideo(@PathVariable("title") String title){

        Resource resource =
                this.resourceLoader.getResource(
                        "classpath:video/" + title + ".mp4");

        return Mono.fromSupplier(() -> resource);

    }


}

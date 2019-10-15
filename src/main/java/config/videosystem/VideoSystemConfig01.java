package config.videosystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ DVDPlayerConfig2.class, DVDConfig.class})
public class VideoSystemConfig01 {
}

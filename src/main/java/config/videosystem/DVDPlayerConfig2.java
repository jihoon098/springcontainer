package config.videosystem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.co.itcen.springcontainer.videosystem.DVDPlayer;
import kr.co.itcen.springcontainer.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig2 {
	@Bean
	public DVDPlayer dvdPlayer(@Qualifier("avengersInfinityWar") DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
}

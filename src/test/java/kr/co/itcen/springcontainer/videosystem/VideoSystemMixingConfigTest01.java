package kr.co.itcen.springcontainer.videosystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.videosystem.VideoSystemConfig01;

/*
 *  Explicit(명시적) Configuration - Java Mixing Config
 *  
 *  JavaConfig <-----  {JavaConfig1, JavaConfig2, JavaConfig3}
 *             import
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {VideoSystemConfig01.class})
public class VideoSystemMixingConfigTest01 {

	@Autowired
	DVDPlayer player;
	
	@Test
	public void testPlyerNull() {
		assertNotNull(player);
	}
}

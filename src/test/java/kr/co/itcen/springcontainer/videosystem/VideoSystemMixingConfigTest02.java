package kr.co.itcen.springcontainer.videosystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.videosystem.VideoSystemConfig02;

/*
 *  Explicit(명시적) Configuration - Java Mixing Config
 *  
 *  JavaConfig   <-----  import {JavaConfig1, JavaConfig2, .... }
 *                       importResource { xml1, xml2, .... }
 *                
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {VideoSystemConfig02.class})
public class VideoSystemMixingConfigTest02 {

	@Autowired
	private DVDPlayer player;
	
	@Test
	public void testPlayerNull() {
		assertNotNull(player);
	}
}

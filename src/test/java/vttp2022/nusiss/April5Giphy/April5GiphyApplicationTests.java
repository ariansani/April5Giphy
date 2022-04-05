package vttp2022.nusiss.April5Giphy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vttp2022.nusiss.April5Giphy.models.Giphy;
import vttp2022.nusiss.April5Giphy.services.GiphyService;

@SpringBootTest
class April5GiphyApplicationTests {

	@Autowired
	private GiphyService giphySvc;

	@Test
	void shouldLoad10Images() {
		Optional<List<Giphy>> gifs = giphySvc.findGiphy("dog", 10, 0, "g", "en", "original");
		assertTrue(gifs.isPresent());
	}





}

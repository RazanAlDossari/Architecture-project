package test;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import org.junit.Test;
import java.io.InputStream;
public class TestMe {
    @Test
    public void givenEnglishModel_whenTokenize_thenTokensAreDetected() throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("/models/en-token.bin");
        TokenizerModel model = new TokenizerModel(inputStream);
//        TokenizerME tokenizer = new TokenizerME(model);
//        String[] tokens = tokenizer.tokenize("Baeldung is a Spring Resource.");
        //assertThat(tokens).contains("Baeldung", "is", "a", "Spring", "Resource", ".");
    }

}

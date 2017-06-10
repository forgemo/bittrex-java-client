package de.elbatya.cryptocoins.bittrexclient.util;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author contact@elbatya.de
 */
public class ApiKeySigningUtilTest {

    @Test
    public void createNonce() throws Exception {
        long count = IntStream.range(0,100000)
                .mapToObj(i -> ApiKeySigningUtil.createNonce())
                .distinct()
                .count();

        assertThat(count).isEqualTo(100000L);
    }

    @Test
    public void createSign() throws Exception {
        String sign = ApiKeySigningUtil.createSign("test","secret");
        String expectedSign =
                "f8a4f0a209167bc192a1bffaa01ecdb0" +
                "9e06c57f96530d92ec9ccea0090d290e" +
                "55071306d6b654f26ae0c8721f7e48a2" +
                "d7130b881151f2cec8d61d941a6be88a";

        assertThat(sign).isEqualTo(expectedSign);
    }

}
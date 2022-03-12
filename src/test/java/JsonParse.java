import com.fasterxml.jackson.databind.ObjectMapper;
import domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;


public class JsonParse {

    @Test
    void jsonTypeTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(Paths.get("src/test/resources/files/user.json").toFile(), User.class);
        Assertions.assertThat(user.name).isEqualTo("Jenia");
        Assertions.assertThat(user.surname).isEqualTo("Andreev");
    }
}


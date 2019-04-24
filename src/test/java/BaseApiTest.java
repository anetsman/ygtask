import client.GameClient;
import com.google.inject.Inject;
import ioc.ConfigModule;
import name.falgout.jeffrey.testing.junit5.GuiceExtension;
import name.falgout.jeffrey.testing.junit5.IncludeModule;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.RequestUtils;

@ExtendWith(GuiceExtension.class)
@IncludeModule(ConfigModule.class)
public class BaseApiTest {

    @Inject
    public RequestUtils request;

    @Inject
    public GameClient gameClient;
}

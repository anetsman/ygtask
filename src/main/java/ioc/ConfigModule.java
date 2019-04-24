package ioc;

import client.GameClient;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import utils.RequestUtils;

import java.util.Properties;

public class ConfigModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Properties.class).toProvider(PropertiesProvider.class).in(Singleton.class);
        bind(RequestUtils.class).toInstance(new RequestUtils());
        bind(GameClient.class).toInstance(new GameClient());
    }
}

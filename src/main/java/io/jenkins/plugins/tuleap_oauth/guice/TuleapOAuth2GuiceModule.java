package io.jenkins.plugins.tuleap_oauth.guice;

import com.google.inject.AbstractModule;
import io.jenkins.plugins.tuleap_oauth.checks.AccessTokenChecker;
import io.jenkins.plugins.tuleap_oauth.checks.AccessTokenCheckerImpl;
import io.jenkins.plugins.tuleap_oauth.checks.AuthorizationCodeChecker;
import io.jenkins.plugins.tuleap_oauth.checks.AuthorizationCodeCheckerImpl;
import io.jenkins.plugins.tuleap_oauth.helper.PluginHelper;
import io.jenkins.plugins.tuleap_oauth.helper.PluginHelperImpl;
import io.jenkins.plugins.tuleap_oauth.okhttp.OkHttpClientProvider;
import io.jenkins.plugins.tuleap_oauth.pkce.PKCECodeBuilder;
import io.jenkins.plugins.tuleap_oauth.pkce.PKCECodeBuilderImpl;
import okhttp3.OkHttpClient;

public class TuleapOAuth2GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AuthorizationCodeChecker.class).to(AuthorizationCodeCheckerImpl.class);
        bind(PluginHelper.class).to(PluginHelperImpl.class);
        bind(AccessTokenChecker.class).to(AccessTokenCheckerImpl.class);
        bind(PKCECodeBuilder.class).to(PKCECodeBuilderImpl.class);
        bind(OkHttpClient.class).toProvider(OkHttpClientProvider.class).asEagerSingleton();
    }
}
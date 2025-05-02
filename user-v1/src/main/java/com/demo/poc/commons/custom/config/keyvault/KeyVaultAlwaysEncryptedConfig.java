package com.demo.poc.commons.custom.config.keyvault;

import java.util.Collections;

import com.demo.poc.commons.custom.exceptions.AlwaysEncryptedConfigException;
import com.microsoft.sqlserver.jdbc.SQLServerColumnEncryptionAzureKeyVaultProvider;
import com.microsoft.sqlserver.jdbc.SQLServerColumnEncryptionKeyStoreProvider;
import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import lombok.RequiredArgsConstructor;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(KeyVaultProperties.class)
@ConditionalOnProperty(prefix = "azure.keyvault", name = "enabled", havingValue = "true")
@RequiredArgsConstructor
public class KeyVaultAlwaysEncryptedConfig {

  private final KeyVaultProperties properties;

  @Bean
  public SQLServerColumnEncryptionKeyStoreProvider columnEncryptionKeyStoreProvider() {
    SQLServerColumnEncryptionAzureKeyVaultProvider provider;
    try {
      provider = new SQLServerColumnEncryptionAzureKeyVaultProvider(properties.getClientId(), properties.getClientSecret());

      SQLServerConnection.registerColumnEncryptionKeyStoreProviders(
          Collections.singletonMap(provider.getName(), provider)
      );

    } catch (SQLServerException exception) {
      throw new AlwaysEncryptedConfigException();
    }
    return provider;
  }
}

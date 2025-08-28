package com.demo.service.commons.config.keyvault;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "azure.keyvault")
@Getter
@Setter
public class KeyVaultProperties {

  private boolean enabled;

  private String clientId;

  private String clientSecret;

  private String uri;
}
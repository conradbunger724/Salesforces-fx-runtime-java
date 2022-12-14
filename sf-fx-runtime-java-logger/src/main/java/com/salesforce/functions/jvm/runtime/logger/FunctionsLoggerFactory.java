/*
 * Copyright (c) 2022, salesforce.com, inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */
package com.salesforce.functions.jvm.runtime.logger;

import java.time.Clock;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.event.Level;

public class FunctionsLoggerFactory implements ILoggerFactory {
  private final LoggingConfiguration loggerConfiguration;
  private final LoggingFormatter loggingFormatter;

  public FunctionsLoggerFactory() {
    loggerConfiguration = LoggingConfigurator.configureFromEnvironment(System.getenv());
    loggingFormatter = new LogFmtLoggingFormatter(Clock.systemDefaultZone());
  }

  @Override
  public Logger getLogger(String name) {
    Level logLevel = loggerConfiguration.getLogLevelForLoggerName(name);
    return new FunctionsLogger(name, logLevel, loggingFormatter);
  }
}

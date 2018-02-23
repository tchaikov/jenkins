/*
 * The MIT License
 *
 * Copyright (c) 2018, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package jenkins.security;

import hudson.Extension;
import jenkins.model.GlobalConfiguration;
import jenkins.model.GlobalConfigurationCategory;
import jenkins.model.Jenkins;
import org.jenkinsci.Symbol;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;

/**
 * Configuration for the new token generation when a user is created
 *
 * @since TODO
 */
@Extension 
@Symbol("apiToken")
public class ApiTokenPropertyConfiguration extends GlobalConfiguration {
    private boolean tokenGenerationOnCreationEnabled = true;
    private boolean creationOfLegacyTokenEnabled = true;
    
    public static ApiTokenPropertyConfiguration get() {
        return Jenkins.get().getInjector().getInstance(ApiTokenPropertyConfiguration.class);
    }

    public ApiTokenPropertyConfiguration() {
        load();
    }

    public boolean isTokenGenerationOnCreationEnabled() {
        return tokenGenerationOnCreationEnabled;
    }

    public void setTokenGenerationOnCreationEnabled(boolean tokenGenerationOnCreationEnabled) {
        this.tokenGenerationOnCreationEnabled = tokenGenerationOnCreationEnabled;
        save();
    }

    public boolean isCreationOfLegacyTokenEnabled() {
        return creationOfLegacyTokenEnabled;
    }

    public void setCreationOfLegacyTokenEnabled(boolean creationOfLegacyTokenEnabled) {
        this.creationOfLegacyTokenEnabled = creationOfLegacyTokenEnabled;
        save();
    }

    @Override 
    public GlobalConfigurationCategory getCategory() {
        return GlobalConfigurationCategory.get(GlobalConfigurationCategory.Security.class);
    }
}

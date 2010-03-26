/*
 * Copyright 2007 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.libideas.resources.rg;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.libideas.resources.client.DataResource;
import com.google.gwt.libideas.resources.rebind.ResourceContext;
import com.google.gwt.libideas.resources.rebind.ResourceGenerator;
import com.google.gwt.libideas.resources.rebind.ResourceGeneratorUtil;
import com.google.gwt.user.rebind.SourceWriter;

import java.net.URL;

/**
 * Provides implementations of DataResource.
 */
public final class DataResourceGenerator extends ResourceGenerator {
  private ResourceContext context;

  @Override
  public void init(TreeLogger logger, ResourceContext context) {
    this.context = context;
  }

  @Override
  public void writeAssignment(TreeLogger logger, JMethod method)
      throws UnableToCompleteException {

    URL[] resources =
        ResourceGeneratorUtil.findResources(logger, context, method);

    if (resources.length != 1) {
      logger.log(TreeLogger.ERROR, "Exactly one "
          + ResourceGeneratorUtil.METADATA_TAG + " must be specified", null);
      throw new UnableToCompleteException();
    }

    URL resource = resources[0];
    String outputUrlExpression = context.addToOutput(resource, false);

    SourceWriter sw = context.getSourceWriter();
    // Write the expression to create the subtype.
    sw.println("new " + DataResource.class.getName() + "() {");
    sw.indent();

    // Convenience when examining the generated code.
    sw.println("// " + resource.toExternalForm());

    sw.println("public String getUrl() {");
    sw.indent();
    sw.println("return " + outputUrlExpression + ";");
    sw.outdent();
    sw.println("}");

    sw.println("public String getName() {");
    sw.indent();
    sw.println("return \"" + method.getName() + "\";");
    sw.outdent();
    sw.println("}");

    sw.outdent();
    sw.println("}");
  }
}

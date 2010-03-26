/*
 * Copyright 2008 Google Inc.
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
package com.google.gwt.gen2.demo.scrolltable.client;

import com.google.gwt.gen2.demo.scrolltable.shared.FileTreeTableItem;
import com.google.gwt.gen2.demo.scrolltable.shared.Student;
import com.google.gwt.gen2.table.shared.Request;
import com.google.gwt.gen2.table.shared.SerializableResponse;
import com.google.gwt.gen2.table.shared.TreeRequest;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * A {@link RemoteService} to retrieve row data for the
 * {@link PagingScrollTableDemo}.
 */
@RemoteServiceRelativePath("datasource")
public interface RemoteTableService extends RemoteService {
  SerializableResponse<Student> requestRows(Request request);
  
  SerializableResponse<FileTreeTableItem> requestTreeItems(TreeRequest request);
}

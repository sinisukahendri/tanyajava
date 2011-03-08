/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.template;

import com.tanyajava.model.DownloadItem;
import com.tanyajava.service.DownloadService;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.apache.velocity.runtime.parser.ParseException;
import org.apache.velocity.runtime.parser.node.SimpleNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ifnu
 */
@Repository
public class VelocityEngineString {

    @Autowired
    private DownloadService downloadService;
    private final Map<String, SimpleNode> simpleNodeMap = new HashMap<String, SimpleNode>();

    public void init() {
        
        RuntimeServices runtimeServices = RuntimeSingleton.getRuntimeServices();
        List<DownloadItem> downloadItems = downloadService.getDownloadItems();
        for (DownloadItem downloadItem : downloadItems) {
            parseEmailTemplate(downloadItem, runtimeServices);

        }
    }

    public SimpleNode getSimpleNode(DownloadItem downloadItem){
        if(simpleNodeMap.isEmpty()){
            init();
        }
        return simpleNodeMap.get(downloadItem.getId());
    }

    private void parseEmailTemplate(DownloadItem downloadItem, RuntimeServices runtimeServices) {
        try {
            StringReader reader = new StringReader(downloadItem.getEmailTemplate());
            SimpleNode node = runtimeServices.parse(reader, downloadItem.getId());
            simpleNodeMap.put(downloadItem.getId(), node);
        } catch (ParseException ex) {
            Logger.getLogger(VelocityEngineString.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reparseDownloadItem(DownloadItem downloadItem){
        RuntimeServices runtimeServices = RuntimeSingleton.getRuntimeServices();
        parseEmailTemplate(downloadItem, runtimeServices);
    }

}

package io.chestnut.server.gateway;

import java.util.Collection;
import java.util.HashMap;

import io.chestnut.core.gateway.ServiceNode;

public class NodeLoad  {
	@SuppressWarnings("unchecked")
	public static HashMap<String, ServiceNode>[] serverServiceNode = new HashMap[10240];
	public static ServiceNode getServiceNode(String serviceName, int serverId) {
		HashMap<String,ServiceNode> serviceMap = serverServiceNode[serverId];
		if(serviceMap == null) {
			serviceMap = new HashMap<>();
			serverServiceNode[serverId] = serviceMap;
		}
		ServiceNode serviceNode = serviceMap.get(serviceName);
		if(serviceNode == null) {
			Collection<ServiceNode> serviceNodeList = GateWay.chestnutTree.getServiceNodeList(serviceName);
			for (ServiceNode serviceNode2 : serviceNodeList) {
				serviceNode = serviceNode2;
				serviceMap.put(serviceName, serviceNode);
				break;
			}
		}
		return serviceNode;
	}

}

package model;

public class ModelProxy implements model.Model {
  private String _endpoint = null;
  private model.Model model = null;
  
  public ModelProxy() {
    _initModelProxy();
  }
  
  public ModelProxy(String endpoint) {
    _endpoint = endpoint;
    _initModelProxy();
  }
  
  private void _initModelProxy() {
    try {
      model = (new model.ModelServiceLocator()).getModel();
      if (model != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)model)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)model)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (model != null)
      ((javax.xml.rpc.Stub)model)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public model.Model getModel() {
    if (model == null)
      _initModelProxy();
    return model;
  }
  
  public java.lang.String getProductInfo(java.lang.String bid) throws java.rmi.RemoteException{
    if (model == null)
      _initModelProxy();
    return model.getProductInfo(bid);
  }
  
  
}
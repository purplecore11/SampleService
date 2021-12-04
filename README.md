# SampleService
This is a simple Spring Boot project.


  <H1>REST Services</H1>
 <ul>
   <li><h3>GET /property</h3> 
     Gets the property given by the parameter name
     <p>If the property name doesn't exist or its value is different to true, it returns 404
     <p>If the param name is not given, it returns 404
     <p>Otherwise, it returns 200
   </li>
   <li><h3>POST /property</h3> 
     Sets a System Property, sending a JSON document with elements propertyName and propertyValue
   </li>
</ul>

package com.exemplo;
   
  import java.net.UnknownHostException;
  import java.util.List;
   
   
  import com.mongodb.BasicDBObject;
  import com.mongodb.DB;
  import com.mongodb.DBCollection;
  import com.mongodb.DBCursor;
  import com.mongodb.Mongo;
  import com.mongodb.MongoException;
   
   
  public class ExemploMongoDB {
   
         public static void main(String args[]){
   
               Mongo mongo = null;
			try {
				mongo = new Mongo("localhost", 27017);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   
               DB db = mongo.getDB("testemongodb");
               
               BasicDBObject doc = new BasicDBObject("username", "daniel").
                             append("nome",   "Daniel Lima").
                             append("cidade", "Patos de MInas");
                             
             DBCollection collec = db.getCollection("dados");
               
               collec.insert(doc);
             
             //lista as coleções
             DBCursor cursor = collec.find();
          int i=1;
          while (cursor.hasNext()) { 
             System.out.println("Documento Inserido: "+i); 
             System.out.println(cursor.next()); 
             i++;
          }
         
          System.out.println("Banco de dados armazenados:");
               List<String> dbs = mongo.getDatabaseNames();
               for(String dbStr : dbs){
                      System.out.println(dbStr);
               }
               
               System.out.println("fim execucao");
             
       }
       
} 
//Devuelve el cif importado por los competidores no nulos, por mes y por categoria de producto
db.Competidores.aggregate([
							{
  							$match:{"COMPETITOR_NAME":{$ne:null}}
  							},
  							
							{
							  $group:{
  							  		_id:{
  							  		  Company:"$COMPETITOR_NAME", 
  							  		  product_category:"$PRODUCT_CATEGORY",
  							  		  month:{$month:"$FECHA DESPACHO"}
  							  		  
  							  		},  							  		
  							  		total_imports:{$sum:"$CIF U$S"},
  							  		toal_quantity:{$sum:"$UNIDADES"}
  							  		}
  							}
  							])


db.Competidores.aggregate([
							{
  							$match:{"COMPETITOR_NAME":{$ne:null}}
  							},
  							
							{
							  $group:{
  							  		_id:{
  							  		  Company:"$COMPETITOR_NAME", 
  							  		  month:{$month:"$FECHA DESPACHO"}
  							  		},  							  		
  							  		total_imports:{$sum:"$CIF U$S"}
  							  		}
  							}
  							])
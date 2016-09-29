db.Competidores.aggregate([
							{
  							$match:{"RUC":{$in:["1791251237001", "1768152560001", "1791256115001" ]}, "COMPETITOR_NAME":{$ne:null}}
  							},
  							
							{
							  $group:{
  							  		_id:{
  							  		  Customer:"$RAZON SOCIAL",
  							  		  Company:"$COMPETITOR_NAME", 
  							  		  month:{$month:"$FECHA DESPACHO"}
  							  		},  							  		
  							  		total_imports:{$sum:"$CIF U$S"}
  							  		}
  							}
  							])
CREATE  PROCEDURE airports_indoor_location_db.calculo_estadia_zona()
   BEGIN 
   
   delete from airports_indoor_location_db.posiciones_aux;
   
   
   insert into airports_indoor_location_db.posiciones_aux
	SELECT    id_usuario,
          zone,
          momento_posicion,
          @curRank := @curRank + 1 AS rank
	FROM      airports_indoor_location_db.flow_analysis p, (SELECT @curRank := 0) r
	ORDER BY  id_usuario,momento_posicion;
    
    delete from airports_indoor_location_db.posicion_aux_2;
    
	insert into airports_indoor_location_db.posicion_aux_2
	select a.id_usuario,a.zone,a.fecha_inicio,b.fecha_inicio, (time_to_sec(coalesce(b.fecha_inicio, least(addtime(a.fecha_inicio,2000),current_timestamp)))- time_to_sec(a.fecha_inicio))/60
	from airports_indoor_location_db.posiciones_aux a 
	left join airports_indoor_location_db.posiciones_aux b
	on a.id_usuario=b.id_usuario
	and a.rank=b.rank-1;
    
    delete from airports_indoor_location_db.agg_estadisticas_flow
    where fecha in (select distinct cast(fecha_inicio as date) from airports_indoor_location_db.posicion_aux_2);
    
    insert into airports_indoor_location_db.agg_estadisticas_flow
    select cast(fecha_inicio as date), hour(fecha_inicio), zone, count(distinct id_usuario),avg(duracion_estadia)
	from airports_indoor_location_db.posicion_aux_2
	group by cast(fecha_inicio as date), hour(fecha_inicio), zone
    ;
    
    delete from airports_indoor_location_db.demora_actual;
    
    insert into airports_indoor_location_db.demora_actual
    select a.zone, avg(duracion_estadia) from airports_indoor_location_db.posicion_aux_2 a
    join (select zone, max(hour(fecha_inicio)) hora from airports_indoor_location_db.posicion_aux_2 group by zone) b
    on a.zone=b.zone and hour(fecha_inicio)=b.hora
    group by a.zone
    ;
   
   
   END //
 DELIMITER ;

##Borrado de tablas
delete from airports_indoor_location_db.nodes;

delete from airports_indoor_location_db.edges;

#Creacion de Nodo 1
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y)
values('1',0,0,0,1,0);

#Creacion de Nodo 2
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y)
values('2',0,0,0,3,1);

#Creacion de Nodo 3
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y)
values('3',0,0,0,0,1);

#Creacion de Nodo 4
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y)
values('4',0,0,0,3,2);

#Creacion de Nodo 5
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y)
values('5',0,0,0,5,2);

#Creacion de Nodo 6
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y)
values('6',0,0,0,0,3);

#Creacion de Nodo 7
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y)
values('7',0,0,0,2,4);

#Creacion de Nodo 8
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y)
values('8',0,0,0,4,5);

#Creacion de Nodo 9
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y)
values('9',0,0,0,6,5);

#Creacion de Nodo 10
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y)
values('10',0,0,0,3,6);

#Creacion de Nodo 11
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y)
values('11',0,0,0,4,6);

#Creacion de Nodo 12
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y)
values('12',0,0,0,0,6);

#Creacion de Nodo 13
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y)
values('13',0,0,0,2,7);

#Creacion de Nodo 14
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y)
values('14',0,0,0,5,7);

#Creacion de Edges de Nodo 1
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('1',1,'1','2');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('2',3,'1','3');

#Creacion de Edges de Nodo 2
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('3',1,'2','1');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('4',1,'2','4');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('5',3,'2','5');

#Creacion de Edges de Nodo 3
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('6',3,'3','1');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('7',1,'3','6');

#Creacion de Edges de Nodo 4
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('8',1,'4','2');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('9',1,'4','6');

#Creacion de Edges de Nodo 5
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('10',3,'5','2');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('11',1,'5','9');

#Creacion de Edges de Nodo 6
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('12',1,'6','3');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('13',1,'6','4');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('14',1,'6','7');

#Creacion de Edges de Nodo 7
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('15',1,'7','6');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('16',1,'7','8');

#Creacion de Edges de Nodo 8
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('17',1,'8','7');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('18',1,'8','9');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('19',1,'8','10');

#Creacion de Edges de Nodo 9
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('20',1,'9','8');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('21',1,'9','5');

#Creacion de Edges de Nodo 10
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('22',1,'10','12');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('23',1,'10','11');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('24',1,'10','8');

#Creacion de Edges de Nodo 11
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('25',1,'11','10');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('26',1,'11','13');

#Creacion de Edges de Nodo 12
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('27',1,'12','10');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('28',1,'12','13');

#Creacion de Edges de Nodo 13
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('29',1,'13','11');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('30',1,'13','12');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('31',1,'13','14');

#Creacion de Edges de Nodo 14
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value)
values('32',1,'14','13');



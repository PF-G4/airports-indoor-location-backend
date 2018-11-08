delete from airports_indoor_location_db.nodes;
delete from airports_indoor_location_db.edges;

insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y) values('le2',0,0,0,1,1);
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y) values('br2',0,0,0,2,1);
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y) values('le1',0,0,0,3,2);
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y) values('ca2',0,0,0,3,3);
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y) values('co1',0,0,0,3,5);
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y) values('br1',0,0,0,4,3);
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y) values('ca1',0,0,0,4,4);
insert into airports_indoor_location_db.nodes (value,f_scores,g_scores,h_scores,pos_x,pos_y) values('co2',0,0,0,4,5);

insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value) values(1,1,'le2','br2');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value) values(2,1,'br2','le1');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value) values(3,1,'le1','ca2');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value) values(4,1,'ca2','br1');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value) values(5,1,'ca2','co1');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value) values(6,1,'co1','co2');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value) values(7,1,'co2','ca1');

insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value) values(8,1,'br2','le2');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value) values(9,1,'le1','br2');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value) values(10,1,'ca2','le1');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value) values(11,1,'br1','ca2');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value) values(12,1,'co1','ca2');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value) values(13,1,'co2','co1');
insert into airports_indoor_location_db.edges (edge_id,cost,origin_value,target_value) values(14,1,'ca1','co2');
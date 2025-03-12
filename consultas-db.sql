#1 Clientes con el número de mascotas que poseen y sus nombres
SELECT c.id, c.nombre AS cliente, COUNT(m.id) AS num_mascotas,
       STRING_AGG(m.nombre, ', ') AS nombres_mascotas
FROM clientes c
LEFT JOIN mascotas m ON c.id = m.dueno_id
GROUP BY c.id, c.nombre
ORDER BY num_mascotas DESC;

#2 Medicamentos con cantidad en stock, destacando los de stock bajo
SELECT id, nombre, cantidad_stock,
       CASE 
           WHEN cantidad_stock < 5 THEN 'Stock Bajo'
           ELSE 'Suficiente'
       END AS estado_stock
FROM medicamentos
ORDER BY cantidad_stock ASC;

#3 Cantidad de mascotas por especie
SELECT especie, COUNT(*) AS total
FROM mascotas
GROUP BY especie
ORDER BY total DESC;

#4 Mascotas en estado "Crítico" ordenadas por fecha de registro
SELECT h.mascota_id, m.nombre AS mascota, h.fecha_hora, h.comentario
FROM historial_estados h
JOIN mascotas m ON h.mascota_id = m.id
JOIN estados e ON h.estado_id = e.id
WHERE e.nombre = 'Crítico'
ORDER BY h.fecha_hora DESC;

#5 Cantidad de aplicaciones de medicamentos realizadas por cada veterinario en un período determinado
SELECT e.id, e.nombre AS veterinario, COUNT(a.id_aplicacion) AS total_aplicaciones
FROM aplicaciones a
JOIN empleados e ON a.veterinario_id = e.id
WHERE a.fecha_aplicacion BETWEEN '2024-01-01' AND '2024-12-31'
GROUP BY e.id, e.nombre
ORDER BY total_aplicaciones DESC;

#6 Evolución de los estados de una mascota seleccionada
SELECT h.mascota_id, m.nombre AS mascota, e.nombre AS estado, h.fecha_hora, h.comentario
FROM historial_estados h
JOIN mascotas m ON h.mascota_id = m.id
JOIN estados e ON h.estado_id = e.id
WHERE m.nombre = 'Pikachu'
ORDER BY h.fecha_hora;

#7 Clientes con más visitas médicas en el último semestre
SELECT c.id, c.nombre AS cliente, COUNT(a.id_aplicacion) AS total_visitas
FROM aplicaciones a
JOIN mascotas m ON a.mascota_id = m.id
JOIN clientes c ON m.dueno_id = c.id
WHERE a.fecha_aplicacion >= NOW() - INTERVAL '6 months'
GROUP BY c.id, c.nombre
ORDER BY total_visitas DESC;

#8 Mascotas que requieren vacuna en el mes actual
SELECT a.mascota_id, m.nombre AS mascota, a.medicamento_id, md.nombre AS medicamento, a.fecha_aplicacion
FROM aplicaciones a
JOIN mascotas m ON a.mascota_id = m.id
JOIN medicamentos md ON a.medicamento_id = md.id
WHERE EXTRACT(MONTH FROM a.fecha_aplicacion) = EXTRACT(MONTH FROM CURRENT_DATE)
AND EXTRACT(YEAR FROM a.fecha_aplicacion) = EXTRACT(YEAR FROM CURRENT_DATE)
ORDER BY a.fecha_aplicacion;

#9 Resumen del uso de cada medicamento
SELECT md.id, md.nombre AS medicamento, COUNT(a.id_aplicacion) AS total_aplicaciones,
       SUM(md.cantidad_stock) AS stock_utilizado
FROM aplicaciones a
JOIN medicamentos md ON a.medicamento_id = md.id
GROUP BY md.id, md.nombre
ORDER BY total_aplicaciones DESC;

#10 Total de ventas diarias de medicamentos
SELECT DATE(a.fecha_aplicacion) AS fecha, 
       SUM(md.precio) AS total_ventas
FROM aplicaciones a
JOIN medicamentos md ON a.medicamento_id = md.id
GROUP BY DATE(a.fecha_aplicacion)
ORDER BY fecha DESC;

#11 Tiempo transcurrido entre “Consulta” y “Recuperándose” o “Dado de Alta”
SELECT h1.mascota_id, m.nombre AS mascota,
       MIN(h1.fecha_hora) AS fecha_consulta,
       MIN(h2.fecha_hora) AS fecha_recuperacion,
       AGE(MIN(h2.fecha_hora), MIN(h1.fecha_hora)) AS tiempo_transcurrido
FROM historial_estados h1
JOIN historial_estados h2 ON h1.mascota_id = h2.mascota_id
JOIN mascotas m ON h1.mascota_id = m.id
JOIN estados e1 ON h1.estado_id = e1.id
JOIN estados e2 ON h2.estado_id = e2.id
WHERE e1.nombre = 'Consulta' 
AND e2.nombre IN ('Recuperándose', 'Dado de Alta')
GROUP BY h1.mascota_id, m.nombre;

#12 Desempeño de veterinarios: tratamientos realizados y evolución de estados
SELECT e.id, e.nombre AS veterinario,
       COUNT(DISTINCT a.id_aplicacion) AS total_tratamientos,
       COUNT(DISTINCT CASE WHEN e2.nombre = 'Crítico' AND e3.nombre = 'Estable' THEN h.mascota_id END) AS recuperaciones
FROM aplicaciones a
JOIN empleados e ON a.veterinario_id = e.id
JOIN historial_estados h ON h.veterinario_id = e.id
JOIN estados e2 ON h.estado_id = e2.id
LEFT JOIN historial_estados h2 ON h.mascota_id = h2.mascota_id AND h2.fecha_hora > h.fecha_hora
LEFT JOIN estados e3 ON h2.estado_id = e3.id
GROUP BY e.id, e.nombre
ORDER BY total_tratamientos DESC;


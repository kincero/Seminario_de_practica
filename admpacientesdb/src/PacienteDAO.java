/**
 * Programa Administración de Pacientes
 * @author Marcos Scharfspitz
 */

 import java.sql.*;
 import java.util.ArrayList;
 import java.util.List;
 import java.time.LocalDate;

 public class PacienteDAO {
 
    // datos de la conexión
     private Connection conectar() throws SQLException {
         String url = "jdbc:mysql://localhost:3306/admin_pacientes";
         String user = "root";
         String password = "basemysql";
         return DriverManager.getConnection(url, user, password);
     }
 
     // obtener los planes cargados
     public List<Plan> obtenerPlanes() {
         List<Plan> planes = new ArrayList<>();
         String query = "SELECT id_plan, nombre, abreviatura FROM PLAN WHERE flg_baja = 0";
         
         try (Connection con = conectar();
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(query)) {
             
             while (rs.next()) {
                 int id = rs.getInt("id_plan");
                 String nombre = rs.getString("nombre");
                 String abreviatura = rs.getString("abreviatura");
                 planes.add(new Plan(id, nombre, abreviatura));
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return planes;
     }
 
     // obtener las localidades cargadas
     public List<Localidad> obtenerLocalidades() {
         List<Localidad> localidades = new ArrayList<>();
         String query = "SELECT id_localidad, nombre, nod_Postal FROM LOCALIDAD WHERE flg_baja = 0";
         
         try (Connection con = conectar();
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(query)) {
             
             while (rs.next()) {
                 int id = rs.getInt("id_localidad");
                 String nombre = rs.getString("nombre");
                 String codPostal = rs.getString("nod_Postal");
                 localidades.add(new Localidad(id, nombre, codPostal));
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return localidades;
     }
 
     // método para el guardado de datos
     public void guardarPaciente(Paciente paciente) {
         String query = "INSERT INTO PACIENTE (nombre, DNI, domicilio, telefono, email, fecha_nacimiento, sexo, id_plan, id_localidad, flg_baja) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 0)";
         
         try (Connection con = conectar();
              PreparedStatement pstmt = con.prepareStatement(query)) {
             
             pstmt.setString(1, paciente.getNombre());
             pstmt.setString(2, paciente.getDni());
             pstmt.setString(3, paciente.getDomicilio());
             pstmt.setString(4, paciente.getTelefono());
             pstmt.setString(5, paciente.getEmail());
             pstmt.setDate(6, Date.valueOf(paciente.getFechaNacimiento()));
             pstmt.setString(7, paciente.getSexo());
             pstmt.setInt(8, paciente.getPlan().getId());
             pstmt.setInt(9, paciente.getLocalidad().getId());
             
             pstmt.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
 
     // método para el actualizado de datos
     public void actualizarPaciente(Paciente paciente) {
         String query = "UPDATE PACIENTE SET nombre = ?, domicilio = ?, telefono = ?, email = ?, fecha_nacimiento = ?, sexo = ?, id_plan = ?, id_localidad = ? " +
                        "WHERE DNI = ? AND flg_baja = 0";
         
         try (Connection con = conectar();
              PreparedStatement pstmt = con.prepareStatement(query)) {
             
             pstmt.setString(1, paciente.getNombre());
             pstmt.setString(2, paciente.getDomicilio());
             pstmt.setString(3, paciente.getTelefono());
             pstmt.setString(4, paciente.getEmail());
             pstmt.setDate(5, Date.valueOf(paciente.getFechaNacimiento()));
             pstmt.setString(6, paciente.getSexo());
             pstmt.setInt(7, paciente.getPlan().getId());
             pstmt.setInt(8, paciente.getLocalidad().getId());
             pstmt.setString(9, paciente.getDni());
             
             pstmt.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
 
     // método para eliminar datos
     public void eliminarPaciente(String dni) {
         String query = "UPDATE PACIENTE SET flg_baja = 1 WHERE DNI = ?";
         
         try (Connection con = conectar();
              PreparedStatement pstmt = con.prepareStatement(query)) {
             
             pstmt.setString(1, dni);
             pstmt.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
 
    // método para listar datos
     public List<Paciente> listarPacientes() {
         List<Paciente> pacientes = new ArrayList<>();
         String query = "SELECT p.id_paciente, p.nombre, p.DNI, p.domicilio, p.telefono, p.email, p.fecha_nacimiento, p.sexo, l.id_localidad, l.nombre as localidad_nombre, l.nod_Postal, pl.id_plan, pl.nombre as plan_nombre, pl.abreviatura " +
                        "FROM PACIENTE p " +
                        "JOIN LOCALIDAD l ON p.id_localidad = l.id_localidad " +
                        "JOIN PLAN pl ON p.id_plan = pl.id_plan " +
                        "WHERE p.flg_baja = 0";
         
         try (Connection con = conectar();
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(query)) {
             
             while (rs.next()) {
                 //int idPaciente = rs.getInt("id_paciente");
                 String nombre = rs.getString("nombre");
                 String dni = rs.getString("DNI");
                 String domicilio = rs.getString("domicilio");
                 String telefono = rs.getString("telefono");
                 String email = rs.getString("email");
                 LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
                 String sexo = rs.getString("sexo");
                 
                 int idLocalidad = rs.getInt("id_localidad");
                 String nombreLocalidad = rs.getString("localidad_nombre");
                 String codPostal = rs.getString("nod_Postal");
                 Localidad localidad = new Localidad(idLocalidad, nombreLocalidad, codPostal);
                 
                 int idPlan = rs.getInt("id_plan");
                 String nombrePlan = rs.getString("plan_nombre");
                 String abreviatura = rs.getString("abreviatura");
                 Plan plan = new Plan(idPlan, nombrePlan, abreviatura);
                 
                 Paciente paciente = new Paciente(nombre, dni, fechaNacimiento, domicilio, telefono, email, sexo, localidad, plan);
                 pacientes.add(paciente);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return pacientes;
     }
 
     // método para buscar paciente por DNI
     public Paciente buscarPacientePorDni(String dni) {
         String query = "SELECT p.id_paciente, p.nombre, p.DNI, p.domicilio, p.telefono, p.email, p.fecha_nacimiento, p.sexo, l.id_localidad, l.nombre as localidad_nombre, l.nod_Postal, pl.id_plan, pl.nombre as plan_nombre, pl.abreviatura " +
                        "FROM PACIENTE p " +
                        "JOIN LOCALIDAD l ON p.id_localidad = l.id_localidad " +
                        "JOIN PLAN pl ON p.id_plan = pl.id_plan " +
                        "WHERE p.flg_baja = 0 AND p.DNI = ?";
         
         try (Connection con = conectar();
              PreparedStatement pstmt = con.prepareStatement(query)) {
             
             pstmt.setString(1, dni);
             ResultSet rs = pstmt.executeQuery();
             
             if (rs.next()) {
                 //int idPaciente = rs.getInt("id_paciente");
                 String nombre = rs.getString("nombre");
                 String domicilio = rs.getString("domicilio");
                 String telefono = rs.getString("telefono");
                 String email = rs.getString("email");
                 LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
                 String sexo = rs.getString("sexo");
                 
                 int idLocalidad = rs.getInt("id_localidad");
                 String nombreLocalidad = rs.getString("localidad_nombre");
                 String codPostal = rs.getString("nod_Postal");
                 Localidad localidad = new Localidad(idLocalidad, nombreLocalidad, codPostal);
                 
                 int idPlan = rs.getInt("id_plan");
                 String nombrePlan = rs.getString("plan_nombre");
                 String abreviatura = rs.getString("abreviatura");
                 Plan plan = new Plan(idPlan, nombrePlan, abreviatura);
                 
                 return new Paciente(nombre, dni, fechaNacimiento, domicilio, telefono, email, sexo, localidad, plan);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return null;
     }
 }
 

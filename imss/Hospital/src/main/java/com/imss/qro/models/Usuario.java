package com.imss.qro.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer usuarioId;

    @NotNull(message = "El nombre es obligatorio.")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres.")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotNull(message = "El apellido es obligatorio.")
    @Size(max = 100, message = "El apellido no puede tener más de 100 caracteres.")
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Past(message = "La fecha de nacimiento debe ser una fecha en el pasado.")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Pattern(regexp = "^(Masculino|Femenino|Otro)?$", message = "El género debe ser Masculino, Femenino u Otro.")
    @Column(name = "genero", length = 10)
    private String genero;

    @NotNull(message = "El correo electrónico es obligatorio.")
    @Email(message = "El correo electrónico debe tener un formato válido.")
    @Size(max = 100, message = "El correo electrónico no puede tener más de 100 caracteres.")
    @Column(name = "correo_electronico", nullable = false, length = 100, unique = true)
    private String correoElectronico;

    @Pattern(regexp = "^\\+?\\d{7,20}$", message = "El teléfono debe ser un número válido de entre 7 y 20 dígitos.")
    @Column(name = "telefono", length = 20)
    private String telefono;

    @PastOrPresent(message = "La fecha de registro debe ser en el presente o en el pasado.")
    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @NotNull(message = "El CURP es obligatorio.")
    @Size(min = 18, max = 18, message = "El CURP debe tener exactamente 18 caracteres.")
    @Column(name = "curp", length = 18, nullable = false)
    private String CURP;

    @Size(max = 13, message = "El RFC no puede tener más de 13 caracteres.")
    @Column(name = "RFC", length = 13)
    private String RFC;

    @Size(max = 50, message = "La ciudad no puede tener más de 50 caracteres.")
    @Column(name = "ciudad", length = 50)
    private String ciudad;

    @Size(max = 255, message = "La dirección no puede tener más de 255 caracteres.")
    @Column(name = "direccion", length = 255)
    private String direccion;

    @Size(max = 50, message = "El estado no puede tener más de 50 caracteres.")
    @Column(name = "estado", length = 50)
    private String estado;

    @Size(max = 100, message = "La especialidad no puede tener más de 100 caracteres.")
    @Column(name = "especialidad", length = 100)
    private String especialidad;

    @NotNull(message = "El tipo de usuario es obligatorio.")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private TipoUsuario tipoUsuario;

    // Getters y Setters

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}

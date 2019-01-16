/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean.beanImplementation;

import com.google.gson.annotations.Expose;
import net.daw.helper.EncodingHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import net.daw.bean.genericBeanImplementation.GenericBeanImplementation;
import net.daw.bean.publicBeanInterface.BeanInterface;
import net.daw.dao.publicDaoInterface.DaoInterface;
import net.daw.factory.DaoFactory;

/**
 *
 * @author a044531896d
 */
public class ComicBean extends GenericBeanImplementation implements BeanInterface {

    @Expose
    private String titulo;

    @Expose
    private String desc;

    @Expose
    private String isbn;

    @Expose
    private Date fechapublicacion;

    @Expose
    private String idioma;

    @Expose
    private int pagina;

    @Expose
    private Boolean color;

    @Expose
    private int existencias;

    @Expose
    private float precio;

    @Expose
    private float descuento;

    @Expose
    private String foto;

    @Expose(serialize = false)
    private int id_coleccion;

    @Expose(deserialize = false)
    private ColeccionBean obj_coleccion;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getFechapublicacion() {
        return fechapublicacion;
    }

    public void setFechapublicacion(Date fechapublicacion) {
        this.fechapublicacion = fechapublicacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public Boolean getColor() {
        return color;
    }

    public void setColor(Boolean color) {
        this.color = color;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getId_coleccion() {
        return id_coleccion;
    }

    public void setId_coleccion(int id_coleccion) {
        this.id_coleccion = id_coleccion;
    }

    public ColeccionBean getObj_coleccion() {
        return obj_coleccion;
    }

    public void setObj_coleccion(ColeccionBean obj_coleccion) {
        this.obj_coleccion = obj_coleccion;
    }

    @Override
    public ComicBean fill(ResultSet oResultSet, Connection oConnection, Integer expand, UsuarioBean oUsuarioBeanSession) throws Exception, Exception {
        this.setId(oResultSet.getInt("id"));
        this.setTitulo(oResultSet.getString("titulo"));
        this.setDesc(oResultSet.getString("desc"));
        this.setIsbn(oResultSet.getString("isbn"));
        this.setFechapublicacion(oResultSet.getDate("fechapublicacion"));
        this.setIdioma(oResultSet.getString("idioma"));
        this.setPagina(oResultSet.getInt("pagina"));
        this.setColor(oResultSet.getBoolean("color"));
        this.setExistencias(oResultSet.getInt("existencias"));
        this.setPrecio(oResultSet.getFloat("precio"));
        this.setDescuento(oResultSet.getFloat("descuento"));
        this.setFoto(oResultSet.getString("foto"));

        if (expand > 0) {
            DaoInterface ocoleccionDao = DaoFactory.getDao(oConnection, "coleccion", oUsuarioBeanSession);
            this.setObj_coleccion((ColeccionBean) ocoleccionDao.get(oResultSet.getInt("id_coleccion"), expand - 1));
        } else {
            this.setId_coleccion(oResultSet.getInt("id_coleccion"));
        }

        return this;
    }

    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "id,";
        strColumns += "titulo,";
        strColumns += "`desc`,";
        strColumns += "isbn,";
        strColumns += "fechapublicacion,";
        strColumns += "idioma,";
        strColumns += "pagina,";
        strColumns += "color,";
        strColumns += "existencias,";
        strColumns += "precio,";
        strColumns += "descuento,";
        strColumns += "foto,";
        strColumns += "id_coleccion";

        return strColumns;
    }

    @Override
    public String getValues() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Instant instant = fechapublicacion.toInstant();
        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();

        String strColumns = "";
        strColumns += "null,";
        strColumns += EncodingHelper.quotate(titulo) + ",";
        strColumns += EncodingHelper.quotate(desc) + ",";
        strColumns += EncodingHelper.quotate(isbn) + ",";
        strColumns += EncodingHelper.quotate(localDate.toString()) + ",";
        strColumns += EncodingHelper.quotate(idioma) + ",";
        strColumns += pagina + ",";
        strColumns += color + ",";
        strColumns += existencias + ",";
        strColumns += precio + ",";
        strColumns += descuento + ",";
        strColumns += EncodingHelper.quotate(foto) + ",";
        strColumns += id_coleccion;

        return strColumns;
    }

    @Override
    public String getPairs() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        
        Instant instant = fechapublicacion.toInstant();
        
        LocalDateTime localDateTime = instant.atZone(defaultZoneId).toLocalDateTime();

        String strPairs = "";
        strPairs += "id=" + id + ",";
        strPairs += "titulo=" + EncodingHelper.quotate(titulo) + ",";
        strPairs += "`desc`=" + EncodingHelper.quotate(desc) + ",";
        strPairs += "isbn=" + EncodingHelper.quotate(isbn) + ",";
        strPairs += "fechapublicacion=" + EncodingHelper.quotate(localDateTime.toString()) + ",";
        strPairs += "idioma=" + EncodingHelper.quotate(idioma) + ",";
        strPairs += "pagina=" + pagina + ",";
        strPairs += "color=" + color + ",";
        strPairs += "existencias=" + existencias + ",";
        strPairs += "precio=" + precio + ",";
        strPairs += "descuento=" + descuento + ",";
        strPairs += "foto=" + EncodingHelper.quotate(foto) + ",";
        if (id_coleccion == 0) {
            strPairs += "id_coleccion=" + obj_coleccion.getId();
        } else {
            strPairs += "id_coleccion=" + id_coleccion;
        }
        strPairs += " WHERE id=" + id;

        return strPairs;
    }

}

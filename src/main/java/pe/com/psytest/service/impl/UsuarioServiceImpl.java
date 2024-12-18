package pe.com.psytest.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.UsuarioEntity;
import pe.com.psytest.repository.UsuarioRepository;
import pe.com.psytest.service.UsuarioService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<UsuarioEntity> findAllUsuarioActive() {
        return usuarioRepository.findAllUsuarioActive();
    }

    @Override
    public List<UsuarioEntity> findAllUsuarioInactive() {
        return usuarioRepository.findAllUsuarioInactive();
    }

    @Override
    public List<UsuarioEntity> findEstudiantesLibres() {
        return usuarioRepository.findEstudiantesLibres();
    }

    @Override
    public List<UsuarioEntity> findPsicologosLibres() {
        return usuarioRepository.findPsicologosLibres();
    }


    @Override
    public UsuarioEntity findById(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id));

    }

    @Override
    public UsuarioEntity add(UsuarioEntity u) {
        u.setFechaRegistro(LocalDate.now());
        u.setHoraModificacion(LocalTime.now());
        u.setFechaModificacion(LocalDate.now());
        return usuarioRepository.save(u);
    }

    @Override
    public UsuarioEntity update(UsuarioEntity u) {
        UsuarioEntity objusu = new UsuarioEntity();
        BeanUtils.copyProperties(u, objusu);
        objusu.setHoraModificacion(LocalTime.now());
        objusu.setFechaModificacion(LocalDate.now());
        return usuarioRepository.save(objusu);
    }

    @Override
    public UsuarioEntity delete(UsuarioEntity u) {
        UsuarioEntity objusu = usuarioRepository.findById(u.getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + u.getId()));
        objusu.setEstado(false);
        return usuarioRepository.save(objusu);
    }
}

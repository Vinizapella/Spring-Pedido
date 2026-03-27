package com.weg.pedido.service;

import com.weg.pedido.dto.request.CursoRequestDto;
import com.weg.pedido.dto.response.CursoReponseDto;
import com.weg.pedido.mapper.CursoMapper;
import com.weg.pedido.model.Curso;
import com.weg.pedido.model.Professor;
import com.weg.pedido.repositorio.CursoRepositorio;
import com.weg.pedido.repositorio.ProfessorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepositorio cursoRepositorio;

    private final CursoMapper cursoMapper;

    private final ProfessorRepositorio professorRepositorio;

    public CursoService(
            CursoRepositorio cursoRepositorio,
            CursoMapper cursoMapper,
            ProfessorRepositorio professorRepositorio
    ) {
        this.cursoRepositorio = cursoRepositorio;
        this.cursoMapper = cursoMapper;
        this.professorRepositorio = professorRepositorio;
    }

    public CursoReponseDto criaCurso(
            CursoRequestDto cursoRequestDto
    ){
        Curso curso = cursoMapper.toEntity(cursoRequestDto);

        cursoRepositorio.save(curso);

        return cursoMapper.toResponse(curso);
    }

    public List<CursoReponseDto> cursos(){
        return cursoRepositorio.findAll()
                .stream()
                .map(cursoMapper::toResponse)
                .toList();
    }

    public CursoReponseDto bucaId(
            Integer id
    ){

        Curso curso = cursoRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Curso não encontrado"));

        return cursoMapper.toResponse(curso);
    }

    public List<CursoReponseDto> cursosProfeId(
            Integer professorId
    ){
        List<Curso> cursos = cursoRepositorio.findByProfessorId(professorId);

        return cursos.stream().map(cursoMapper::toResponse).toList();
    }

    public List<CursoReponseDto> buscaCursosProfeNome(
            String nome
    ){
        List<Curso> cursos = cursoRepositorio.findByProfessorNome(nome);

        return cursos.stream().map(cursoMapper::toResponse).toList();
    }

    public CursoReponseDto buscaIdNome(
            Integer id,
            String nome
    ){
        Curso curso = cursoRepositorio.findByIdAndNome(id, nome)
                .orElseThrow(()->new RuntimeException("Curso não achado"));

        return cursoMapper.toResponse(curso);
    }

    public CursoReponseDto update(
            Integer id,
            CursoRequestDto cursoRequestDto
    ){
        Curso curso = cursoRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Curso não encontrado"));

        Professor professor = professorRepositorio.findById(cursoRequestDto.professorId())
                .orElseThrow(()->new RuntimeException("Professor não encontrado"));

        curso.setNome(cursoRequestDto.nome());
        curso.setProfessor(professor);

        cursoRepositorio.save(curso);

        return cursoMapper.toResponse(curso);
    }

    public void delete(
            Integer id
    ){
        Curso curso = cursoRepositorio.findById(id)
                .orElseThrow(()->new RuntimeException("Curso não encontrado"));

        cursoRepositorio.delete(curso);
    }
}

package com.weg.pedido.service;

import com.weg.pedido.dto.request.ProfessorRequestDto;
import com.weg.pedido.dto.response.ProfessorResponseDto;
import com.weg.pedido.mapper.ProfessorMapper;
import com.weg.pedido.model.Professor;
import com.weg.pedido.repositorio.ProfessorRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepositorio professorRepositorio;

    private final ProfessorMapper professorMapper;

    public ProfessorService(
            ProfessorRepositorio professorRepositorio,
            ProfessorMapper professorMapper
    ) {
        this.professorRepositorio = professorRepositorio;
        this.professorMapper = professorMapper;
    }

    public ProfessorResponseDto cria(
            ProfessorRequestDto professorRequestDto
    ){
        Professor professor = professorMapper.toEntity(professorRequestDto);

        professorRepositorio.save(professor);

        return professorMapper.toResponse(professor);
    }

    public List<ProfessorResponseDto> listarProfessores(){

        return professorRepositorio.findAll()
                .stream()
                .map(professorMapper::toResponse)
                .toList();
    }

    public ProfessorResponseDto findById(
            Integer id
    ){
        Professor professor = professorRepositorio.findById(id)
                .orElseThrow(()->new RuntimeException("Professor nã encontrado"));

        return professorMapper.toResponse(professor);
    }

    public ProfessorResponseDto update(
            ProfessorRequestDto professorRequestDto,
            Integer id
    ){
        Professor professor = professorRepositorio.findById(id)
                .orElseThrow(()->new RuntimeException("Professor não encontrado"));

        professor.setNome(professorRequestDto.nome());
        professor.setEmail(professor.getEmail());
        professor.setEspecialidade(professor.getEspecialidade());

        professorRepositorio.save(professor);

        return professorMapper.toResponse(professor);
    }

    public void delete(
            Integer id
    ){
        Professor professor = professorRepositorio.findById(id)
                .orElseThrow(()->new RuntimeException("Professor não encontrado"));

        professorRepositorio.delete(professor);
    }
}

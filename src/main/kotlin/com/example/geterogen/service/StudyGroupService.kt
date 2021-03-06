package com.example.geterogen.service

import com.example.geterogen.model.StudyGroup
import com.example.geterogen.repository.StudyGroupRepository
import org.springframework.stereotype.Service


@Service
class StudyGroupService(private val repository: StudyGroupRepository) {

    /**
    * Все группы
    */
    fun findAll(): Iterable<StudyGroup> = repository.findAll()

    /**
     * Группа по id
     */
    fun findById(id: Int) = repository.findById(id)


    /**
     * Создание группы
     */
    fun create(studyGroup: StudyGroup) = repository.save(studyGroup)

    /**
     * Удаление группы
     */
    fun delete(id: Int) = repository.deleteById(id)

    /**
     * Редактирование информации о группе
     */
    fun edit(id: Int, group: StudyGroup): StudyGroup {
        val oldGroup = repository.findById(id).get()
        oldGroup.name = group.name
        return repository.save(oldGroup)

    }

}
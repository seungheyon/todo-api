package com.example.todoapi.common.config

import lombok.extern.slf4j.Slf4j
import org.hibernate.query.sqm.tree.SqmNode.log
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


@Component
@Slf4j
class SchedulerConfiguration {

    private val logger = LoggerFactory.getLogger(SchedulerConfiguration::class.java)

    @Scheduled(fixedRate = 5000L)
    fun reportTime(){
        val currentTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val formattedCurrentTime = currentTime.format(formatter)
        logger.info("Current time: $formattedCurrentTime")
    }

}
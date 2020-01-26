package com.raywenderlich.android.creaturemon.presenter

import com.raywenderlich.android.creaturemon.model.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.w3c.dom.Attr
import kotlin.concurrent.timer

class CreaturePresenterTest {

    @Mock
    lateinit var presenter: CreaturePresenter

    @Mock
    lateinit var view: CreatureContract.View

    @Mock
    lateinit var generator: CreatureGenerator

    @Mock
    lateinit var repository: CreatureRepository

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        presenter = CreaturePresenter(generator, repository)
        presenter.setView(view)
    }

    @Test
    fun testIntelligenceSelected(){
        val attributes = CreatureAttributes(10,0,0)
        val creatureGenerated = Creature(attributes, 50)
        `when`(generator.creatureGenerated(attributes)).thenReturn(creatureGenerated)
        presenter.attributeSelected(AttributeType.INTELLIGENCE, 3)
        verify(view, times(1)).showHitPoints("50")
    }

    @Test
    fun testStrengthSelected() {
        val attributes = CreatureAttributes(0,10,0)
        val creatureGenerated = Creature(attributes, 30)
        `when`(generator.creatureGenerated(attributes)).thenReturn(creatureGenerated)
        presenter.attributeSelected(AttributeType.STRENGTH, 3)
        verify(view, times(1)).showHitPoints("30")
    }

    @Test
    fun testEnduranceSelected() {
        val attributes = CreatureAttributes(0,0,10)
        val creatureGenerated = Creature(attributes, 40)
        `when`(generator.creatureGenerated(attributes)).thenReturn(creatureGenerated)
        presenter.attributeSelected(AttributeType.ENDURANCE, 3)
        verify(view, times(1)).showHitPoints("40")
    }
}
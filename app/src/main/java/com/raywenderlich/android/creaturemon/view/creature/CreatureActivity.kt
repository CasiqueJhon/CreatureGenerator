package com.raywenderlich.android.creaturemon.view.creature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.raywenderlich.android.creaturemon.R
import com.raywenderlich.android.creaturemon.model.AttributeStore
import com.raywenderlich.android.creaturemon.model.AttributeType
import com.raywenderlich.android.creaturemon.model.AttributeValue
import com.raywenderlich.android.creaturemon.model.Avatar
import com.raywenderlich.android.creaturemon.presenter.CreatureContract
import com.raywenderlich.android.creaturemon.presenter.CreaturePresenter
import com.raywenderlich.android.creaturemon.view.avatars.AvatarAdapter
import com.raywenderlich.android.creaturemon.view.avatars.AvatarBottomDialogFragment
import kotlinx.android.synthetic.main.activity_creature.*


class CreatureActivity : AppCompatActivity(), AvatarAdapter.AvatarListener, CreatureContract.View {


  private val presenter = CreaturePresenter()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_creature)

    presenter.setView(this)

    configureUI()
    configureSpinnerAdapters()
    configureSpinnerListeners()
    configureEditText()
    configureClickListeners()
  }

  private fun configureUI() {
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    title = getString(R.string.add_creature)
    if (presenter.isDrawableSelected()) hideTapLabel()
  }

  private fun configureSpinnerAdapters() {
    intelligence.adapter = ArrayAdapter<AttributeValue>(this,
        android.R.layout.simple_spinner_dropdown_item, AttributeStore.INTELLIGENCE)
    strength.adapter = ArrayAdapter<AttributeValue>(this,
        android.R.layout.simple_spinner_dropdown_item, AttributeStore.STRENGTH)
    endurance.adapter = ArrayAdapter<AttributeValue>(this,
        android.R.layout.simple_spinner_dropdown_item, AttributeStore.ENDURANCE)
  }

  private fun configureSpinnerListeners() {
    intelligence.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
      override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        presenter.attributeSelected(AttributeType.INTELLIGENCE, position)
      }
      override fun onNothingSelected(parent: AdapterView<*>?) {}
    }
    strength.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
      override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        presenter.attributeSelected(AttributeType.STRENGTH, position)
      }
      override fun onNothingSelected(parent: AdapterView<*>?) {}
    }
    endurance.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
      override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        presenter.attributeSelected(AttributeType.ENDURANCE, position)
      }
      override fun onNothingSelected(parent: AdapterView<*>?) {}
    }
  }

  private fun configureEditText() {
    nameEditText.addTextChangedListener(object : TextWatcher {
      override fun afterTextChanged(name: Editable?) {}
      override fun beforeTextChanged(name: CharSequence?, start: Int, count: Int, after: Int) {}
      override fun onTextChanged(name: CharSequence?, start: Int, before: Int, count: Int) {
        presenter.updateName(name.toString())
      }
    })
  }

  private fun configureClickListeners() {
    avatarImageView.setOnClickListener {
      val bottomDialogFragment = AvatarBottomDialogFragment.newInstance()
      bottomDialogFragment.show(supportFragmentManager, "AvatarBottomDialogFragment")
    }

    saveButton.setOnClickListener {
      presenter.saveCreature()
    }
  }

  override fun avatarClicked(avatar: Avatar) {
    presenter.drawableSelected(avatar.drawable)
    hideTapLabel()
  }

  private fun hideTapLabel() {
    tapLabel.visibility = View.INVISIBLE
  }

  override fun showHitPoints(hitPoints: String) {
    this.hitPoints.text = hitPoints
  }

  override fun showAvatarDrawable(resourceId: Int) {
    avatarImageView.setImageResource(resourceId)
  }

  override fun showCreatureSaved() {
    Toast.makeText(this, getString(R.string.creature_saved),Toast.LENGTH_SHORT).show()
  }

  override fun showCreatureSavedError() {
    Toast.makeText(this, getString(R.string.error_saving_creature), Toast.LENGTH_SHORT).show()
  }
}

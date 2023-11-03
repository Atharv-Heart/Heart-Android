package com.accidentaldeveloper.heart.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.accidentaldeveloper.heart.R



class mission_fragment : Fragment() {
    private val UNITY_REQUEST_CODE = 1



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val unityIntent = Intent()
        unityIntent.action = Intent.ACTION_VIEW
        unityIntent.setClassName("com.atharv.finallll", "com.unity3d.player.UnityPlayerActivity")
        startActivityForResult(unityIntent, UNITY_REQUEST_CODE)

        return inflater.inflate(R.layout.fragment_mission_fragment, container, false)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == UNITY_REQUEST_CODE) {
            // Handle the result of the Unity3D activity
            if (resultCode == Activity.RESULT_OK) {

            } else {
                Toast.makeText(requireContext(), "Error or Cancellation occurred", Toast.LENGTH_SHORT).show()
            }
        }

  }
}

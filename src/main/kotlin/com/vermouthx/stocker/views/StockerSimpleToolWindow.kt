package com.vermouthx.stocker.views

import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.ActionPlaces
import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.openapi.ui.SimpleToolWindowPanel
import com.vermouthx.stocker.actions.StockerReloadAction
import com.vermouthx.stocker.actions.StockerStockAddAction
import com.vermouthx.stocker.actions.StockerStockDeleteAction

class StockerSimpleToolWindow : SimpleToolWindowPanel(true) {
    var tableView: StockerTableView = StockerTableView()

    init {
        val actionManager = ActionManager.getInstance()
        val actionGroup =
            DefaultActionGroup(
                listOf(
                    StockerReloadAction::class.qualifiedName?.let { actionManager.getAction(it) },
                    StockerStockAddAction::class.qualifiedName?.let { actionManager.getAction(it) },
                    StockerStockDeleteAction::class.qualifiedName?.let { actionManager.getAction(it) }
                )
            )
        val actionToolbar = actionManager.createActionToolbar(ActionPlaces.TOOLWINDOW_CONTENT, actionGroup, true)
        this.toolbar = actionToolbar.component
        setContent(tableView.component)
    }
}
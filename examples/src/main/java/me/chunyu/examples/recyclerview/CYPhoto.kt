package me.chunyu.examples.recyclerview
import java.io.Serializable

/**
 * Created by huangpeng on 11/11/2017.
 *
 *  this is the raw model, eg. data loaded from network or local db
 */
class CYPhoto : Serializable {
    var title = "hello"
    var url = "http://d.hiphotos.baidu.com/baike/pic/item/bd315c6034a85edf56a873cf43540923dd547532.jpg"
    var humanDate = "11/11/2017"
    var explanation = "world"
}
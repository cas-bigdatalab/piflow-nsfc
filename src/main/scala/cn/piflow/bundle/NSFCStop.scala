package cn.piflow.bundle

import cn.piflow.{JobContext, JobInputStream, JobOutputStream, ProcessContext}
import cn.piflow.conf.{ConfigurableStop, PortEnum}
import cn.piflow.conf.bean.PropertyDescriptor
import cn.piflow.conf.util.{ImageUtil, MapUtil}

/**
  * Created by xjzhu@cnic.cn on 8/22/19
  */
class NSFCStop extends ConfigurableStop{
  override val authorEmail: String = "xjzhu@cnic.cn"
  override val description: String = "Test NSFC compoment"
  override val inportList: List[String] = List(PortEnum.DefaultPort)
  override val outportList: List[String] = List(PortEnum.DefaultPort)

  var propertyTest: String = _

  override def setProperties(map: Map[String, Any]): Unit = {
    propertyTest = MapUtil.get(map,"propertyTest").asInstanceOf[String]
  }

  override def getPropertyDescriptor(): List[PropertyDescriptor] = {
    var descriptor : List[PropertyDescriptor] = List()
    val propertyTestDesc = new PropertyDescriptor().name("propertyTest").displayName("propertyTest").description("Test property").defaultValue("").required(false)
    descriptor = propertyTestDesc :: descriptor
    descriptor
  }

  override def getIcon(): Array[Byte] = {
    ImageUtil.getImage("icon/nsfc.png")
  }

  override def getGroup(): List[String] = {
    List("NSFC")
  }

  override def initialize(ctx: ProcessContext): Unit = {

  }

  override def perform(in: JobInputStream, out: JobOutputStream, pec: JobContext): Unit = {
    val df = in.read()
    out.write(df)
  }
}

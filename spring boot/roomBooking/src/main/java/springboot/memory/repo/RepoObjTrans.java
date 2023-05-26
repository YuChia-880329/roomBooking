package springboot.memory.repo;

import tmpl.trans.bean.obj.ObjRiTrans;
import tmpl.trans.bean.obj.ObjWoTrans;

public abstract class RepoObjTrans<O, D> implements ObjRiTrans<O, D>, ObjWoTrans<O, D> {

}

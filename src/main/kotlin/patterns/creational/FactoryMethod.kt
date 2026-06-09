package patterns.creational

interface ProductoPendienteFactoryMethod {
    fun descripcion(): String
}

//Creando producto concreto
class ProductoFisico : ProductoPendienteFactoryMethod{
    override fun descripcion(): String{
        return "Un producto Físico"
    }
}

class ProductoDigital : ProductoPendienteFactoryMethod {
    override fun descripcion(): String{
        return "Un producto digital"
    }
}

abstract class TallerPendiente {
    fun prepararPedido(): String {
        val producto = crearProductoPendiente()
        return "Pedido preparado para ${producto.descripcion()}"
    }

    protected abstract fun crearProductoPendiente(): ProductoPendienteFactoryMethod
}

class TallerLocal : TallerPendiente(){
    override fun crearProductoPendiente(): ProductoPendienteFactoryMethod{
        return ProductoDigital()
    }
}

class TallerDigital : TallerPendiente(){
    override fun crearProductoPendiente(): ProductoPendienteFactoryMethod{
        return ProductoFisico()
    }
}

class FactoryMethodDemo {
    fun ejecutar(): String {
        val taller: TallerPendiente = TallerLocal()
        
        return taller.prepararPedido()
    }
}

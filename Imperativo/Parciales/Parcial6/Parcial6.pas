program Parcial6;
const
type
	pedido = record
		fecha: String[15];
		monto:	real;
		end;
	cliente = record
		dni: String[9];
		nombre: String[10];
		pedidos: lista;
	lista = ^nodo;
	nodo = record
		elem: pedido;
		sig: lista;
		end;
	
	arbol = ^hoja;
	hoja = record;
		elem: cliente;
		HI:arbol;
		HD:arbol;
		end;
	{	Inciso A	}

procedure leerPedido(var c:cliente; var p:pedido);
begin
	writeln('Ingrese monto ');
	readln(p.monto);
	if(p.monto <> 0)then begin
		writeln('Ingrese dni ');
		readln(c.dni);
		writeln('Ingrese nombre ');
		readln(c.nombre);
		writeln('Ingrese fecha ');
		readln(p.fecha);
	end;
end;

procedure cargarArbol(var a:arbol);
var
	p:pedido;
	c:cliente;
begin
	leerPedido(c,p);
	while(p.monto <> 0)do begin
		agregarArbol(a,c,p);
		leerPedido(c,p);
	end;
end;

procedure agregarArbol(var a:arbol; c:cliente; p:pedido);
var
	nue:arbol;
begin
	if(a <> nil)then begin
		new(nue);
		nue^.elem.dni := c.dni;
		nue^.elem.nombre := c.nombre;
		nue^.elem.pedidos := nil;
		agregarAdelante(nue^.elem.pedidos, p);
		nue^.HI := nil;
		nue^.HD := nil;
	end
	else
		if(a^.elem.dni > c.dni)then
			agregarArbol(a^.HI,c,p);
		else
			if(a^.elem.dni < c.dni)then
				agregarArbol(a^.HD,c,p):
			else
				if(a^.elem.dni = c.dni)
					agregarAdelante(a^.elem.pedidos,p)
			
end;

procedure agregarAdelante(var L:lista; p:pedidos);
var
	nue: lista;
begin
	new(nue);
	nue^.elem.fecha:= p.fecha;
	nue^.elem.monto:= p.monto;
	nue^.sig:= L;
	L:= nue;
end;

	{	Inciso B	}

function buscarPedidoEnFecha(p:lista;f:String):integer;
var
	ok:integer;
begin
	ok:= 0;
	while(p <> nil and ok = 0)do begin
		if(p^.elem.fecha = f) then
			ok:= 1;
		else
			p:= p^.sig
	end;
	buscarPedidoEnFecha:= ok;
end;

procedure cantClientesConPedidosEn(a:arbol; var cantCliente: integer ; f:String);
var
begin
	if(a <> nil) then begin
		cantCliente:= cantCliente + buscarPedidoEnFecha(a^.elem.pedidos,f);
		cantClientesConPedidosEn(a^.HI,cantCliente,f);
		cantClientesConPedidosEn(a^.HD,cantCliente,f);
	end;
end;

	{	Inciso C	}

procedure totalAbonadoYPedidoPorDNI(a:arbol; var totalAbonado,totalPedido:integer; dni:String);
var
begin
	if(a<>nil and a^.elem.dni = dni)then 
		contarAbonadoYPedido(a^.elem.pedidos,totalAbonado,totalPedido);
	else
		if(a^.elem.dni > dni)then
			totalAbonadoYPedidoPorDNI(a^.HI,totalAbonado,totalPedido);
		else
			if(a^.elem.dni < dni)then
				totalAbonadoYPedidoPorDNI(a^.HD,totalAbonado,totalPedido);
end;

procedure contarAbonadoYPedido(p:lista;var totalAbonado,totalPedido:integer);
begin
	while(p <> nil)do begin
		totalPedido:= totalPedido + 1;
		totalAbonado:= totalAbonado + monto;
		p:= p^.sig;
	end;
end;

var
	pizzeria:arbol;
	totalAbonado,totalPedido,cantClientes,:integer;
	fecha:String[15];
	dni:String[9];
begin
	pizzeria:= nil;
	cargarArbol(a);
	
	writeln('Ingrese una fecha ');
	readln(fecha);
	cantClientesConPedidosEn(pizzeria,cantClientes,fecha);
	writeln('la cantidad de clientes en la fecha: ' + fecha + ', es de: ' + cantClientes);
	
	writeln('Ingrese un dni ');
	readln(dni);
	totalAbonadoYPedidoPorDNI(pizzeria,totalAbonado,totalPedido,dni);
	writeln('El total abonado por dni: '+ dni + ', es de: ' + totalAbonado + ', y su total pedido es: ' + totalPedido );
END.

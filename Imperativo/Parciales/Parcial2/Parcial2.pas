program Parcial2;
var
	pasaje = record
		codVuelo: integer;
		codCliente: integer;
		codDestino:integer;
		monto: integer;
		end;
	lista = ^nodo;
	nodo = record
		elem: pasaje;
		sig: lista;
		end;
	arbol = ^hoja;
	hoja = record;
		elem: lista;
		HI:arbol;
		HD:arbol;
		end;
procedure leerPasaje(var p:pasaje);
begin
	p.monto:= readln(p.monto);
	if(p.monto <> 0)then begin
		p.codVuelo:=Random(10);
		p.codCliente:= Random(10);
		p.codDestino:=Random(10);
	end;
end;

procedure agregarAtras(var L:lista; p:partida);
var
	nuevo: lista;
begin
	new(nuevo);
	nuevo^.elem := p;
	nuevo^.sig = nil;
	L:= nuevo;
end;

procedure agregarArbol(var a:arbol; p:pasaje;);
begin
	if(a==nil)then begin
		new(a);
		a^.elem = agregarAtras(a^.elem, p);
		a^.HI = nil;
		a^.HD = nil;
	end;
	else
		if(a^.elem.codDestino == p)then begin
			agregarAtras(a^.elem,p);
		else
			if(p.codCiudad < a^.elem.codCiud)then begin
				agregarArbol(a^.HI,p);
			else 
				agregarArbol(a^.HD,p);
			end;
		end;
end;

procedure cargarArbol(var a:arbol);
var
	p:pasaje;
begin
	leerPasaje(p);
	while(p.monto <> 0)do begin
		agregarAlArbol(a,p);
		leerPasaje(p);
	end;
	
end;
function contarPasajes(L:lista):integer;
var
	cantP:integer;
begin
	cantP:= 0;
	while(L <> nil)do begin
		cantP:= cantP + 1;
		L:= L^.sig;
	end;
	contarPasajes:= cantP;
end;

procedure totalPasajesDestino(a:arbol; cod:integer; var L:lista);
begin
	if(a^.elem.codDestino == cod)then begin
		L:= a^.elem;
	else
		if(cod < a^.elem.codDestino)then begin
			totalPasajesDestino(a^.HI,cod,L);
		else
			totalPasajesDestino(a^.HD,cod,L);
		end;
	end;
end;
//{c) Realizar un módulo que reciba la estructura generada en a) 
// y retorne el código de ciudad de destino con mayor 
// cantidad de pasajes vendidos.}

procedure codigoCiudadMasVendido(a:arbol; var cantMax:integer,var destMax:integer);
var
	cant:integer;
begin
	if(a <> nil)then begin
		codigoCiudadMasVendido(a^.HI,cantMax, destMax);
		cant:= contarPasajes(a^.elem);
		if(cant > cantMax)then begin
			cantMax := cant;
			destMax:= a^.elem.codDestino;
		end;
		codigoCiudadMasVendido(a^.HD,cantMax, destMax);
	end;
end;
var
	a:arbol;
BEGIN
	a:= nil;
	cargarArbol(a);
END.

pull:
	git pull

commit:
	$(MAKE) pull
	git add .
	read -p "Escreva o texto do commit: " text; git commit -m "$$text"
	git push

log:
	$(MAKE) pull
	git log --oneline

reset:
	$(MAKE) log
	read -p "Digite o hash do commit: " hash; git reset --soft $$hash

